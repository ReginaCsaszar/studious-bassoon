#include <jni.h>
#include <string>
#include <stdlib.h>
#include <time.h>
#include <sstream>

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_example_khadr_hello_1cmake_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {

    srand(time(NULL));
    int randNum = rand() % 8 + 1;

    //there's no std::to_string available

    std::ostringstream os ;
    os << randNum ;
    std::string hello = "drawable/cat" + os.str();

    return env->NewStringUTF(hello.c_str());
}

