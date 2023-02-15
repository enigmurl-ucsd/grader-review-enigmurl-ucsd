CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission >git_status.txt 2>&1 

if [[ $? -ne 0 ]] 
then
    echo "FAIL: Could not clone!" $(<git_status.txt)
    exit 1
fi

if ! [[ -f student-submission/ListExamples.java ]]
then
    echo 'FAIL: Could not find file "ListExamples.java"'
    exit 1
fi

cp TestListExamples.java student-submission/TestListExamples.java
if ! [[ -d student-submission/lib ]]
then
    mkdir student-submission/lib
fi
cp -r lib student-submission 

cd student-submission

javac -cp $CPATH *.java 2>compile_error.txt

if [[ $? -ne 0 ]]
then
    echo "FAIL: Error trying to compile files:" $(<compile_error.txt)
    exit 1
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples >run_error.txt 2>&1
ERR=$(grep "Tests run: .*" run_error.txt)

if [[ $? -eq 0 ]]
then
    echo "FAIL:" $ERR
exit 1
fi

echo "SUCCESS: File passed all tests"
exit 0


