@echo off
setlocal
cd /d "%~dp0"
set "REMOTE=deepspace"
set "REPO_URL=https://github.com/evilcatshb/rechiseledae-1.20.1-deepspace-fork.git"
set "BRANCH=deepspace-rechiseledae-1.20.1"

echo === Sky of Grind DeepSpace RechiseledAE2 fork sync ===
where git >nul 2>&1
if errorlevel 1 (echo ERROR: Git is not installed or not on PATH.& exit /b 1)
if not exist ".git" (echo ERROR: This directory is not a Git repository.& exit /b 1)

git remote get-url %REMOTE% >nul 2>&1
if errorlevel 1 git remote add %REMOTE% %REPO_URL%
if errorlevel 1 exit /b 1

git switch %BRANCH% >nul 2>&1
if errorlevel 1 git switch -c %BRANCH%
if errorlevel 1 exit /b 1

echo.
echo Staging source changes and required local dependency JARs...
git add -A
if errorlevel 1 exit /b 1
rem These libraries are referenced directly by build.gradle and are required to build.
git add -f libs/*.jar
if errorlevel 1 exit /b 1

git diff --cached --quiet
if errorlevel 1 (
  git commit -m "Sync Sky of Grind DeepSpace RechiseledAE2 fork"
  if errorlevel 1 exit /b 1
) else (
  echo No new local changes to commit.
)

echo.
echo Pushing %BRANCH% to GitHub...
git push -u %REMOTE% %BRANCH%
if errorlevel 1 (echo ERROR: Push failed. Check authentication or remote status.& exit /b 1)

echo.
echo Sync complete: https://github.com/evilcatshb/rechiseledae-1.20.1-deepspace-fork
echo.
exit /b 0
