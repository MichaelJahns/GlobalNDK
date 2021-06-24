#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jint JNICALL
        Java_com_leyline_global_MainActivity_additionFromJNI(
                JNIEnv * env, jobject, jint number1, jint number2) {
    return number1 + number2;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_leyline_global_MainActivity_subtractFromJNI(JNIEnv *env, jobject thiz, jint number_two,
                                                     jint number_one) {
    return number_one-number_two;
}
extern "C"
JNIEXPORT jint JNICALL
Java_com_leyline_global_MainActivity_multiplyFromJNI(JNIEnv *env, jobject thiz, jint number_two,
                                                     jint number_one) {
    return number_one*number_two;
}
extern "C"
JNIEXPORT jdouble JNICALL
Java_com_leyline_global_MainActivity_divideFromJNI(JNIEnv *env, jobject thiz, jint number_two,
                                                   jint number_one) {
    if(number_two == 0){
        return 0;
    }
    return number_one/number_two;
}