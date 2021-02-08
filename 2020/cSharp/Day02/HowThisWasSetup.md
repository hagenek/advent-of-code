# Setup

## Using dotnet CLI inside a folder named Day02.

1. dotnet new sln 
2. dotnet new console -o Day02Code
3. dotnet new nunit -o Day02Test
4. dotnet sln add Day02Code
5. dotnet sln add Day02Test
6. cd Day2Test
7. dotnet add reference ..\Day2Code\

