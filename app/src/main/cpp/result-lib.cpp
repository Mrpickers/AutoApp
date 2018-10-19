#include <jni.h>
#include <string>
#include <inttypes.h>
#include <iostream>
#define random(x)(rand()%x)

using namespace std;

extern "C"
JNIEXPORT jstring

JNICALL
Java_com_holomatic_myjni_MainActivity_resultFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    std::string hello1 = "Hello from C";
    std::string hello2 = hello+hello1;

    srand((int)time(0));
    int m=random(100);
    //使用到的方法
    //string to int 采用的方法是std::stoi
    std::string n=std::to_string(m);

    return env->NewStringUTF(n.c_str());
    //return env->NewStringUTF(hello2.c_str());

}
