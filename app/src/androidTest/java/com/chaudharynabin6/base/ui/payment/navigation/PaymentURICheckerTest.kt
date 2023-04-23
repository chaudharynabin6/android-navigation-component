package com.chaudharynabin6.base.ui.payment.navigation


import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class PaymentURICheckerTest {

    lateinit var paymentURIChecker: PaymentURIChecker

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        paymentURIChecker = PaymentURIChecker(context)
    }

    @Test
    fun matchAnyBase64URLSafeURI__correctInput_returnsTrue() {
        val testURI = "myapp://payment/paymentType/1"
        val result = paymentURIChecker.matchAnyBase64URLSafeURI(testURI)
        assertThat(result).isTrue()

        val testURI2 =
            "myapp://payment/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-/-1"
        val result2 = paymentURIChecker.matchAnyBase64URLSafeURI(testURI2)
        assertThat(result2).isTrue()

    }

    @Test
    fun matchAnyBase64URLSafeURI__incorrectBase64URL_returnsFalse() {
        val testURI = "myapp://payment/paym\$entType/1"
        val result = paymentURIChecker.matchAnyBase64URLSafeURI(testURI)
        assertThat(result).isFalse()

        val testURI2 = "myapp://payment/{/1"
        val result2 = paymentURIChecker.matchAnyBase64URLSafeURI(testURI2)
        assertThat(result2).isFalse()
    }

    @Test
    fun matchAnyBase64URLSafeURI__incorrectID_returnsFalse() {
        val testURI = "myapp://payment/paymentType/h"
        val result = paymentURIChecker.matchAnyBase64URLSafeURI(testURI)
        assertThat(result).isFalse()

        val testURI2 =
            "myapp://payment/ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=/#"
        val result2 = paymentURIChecker.matchAnyBase64URLSafeURI(testURI2)
        assertThat(result2).isFalse()

    }

    @Test
    fun matchOnlyValueWithInTheEnums__correctInput__ReturnsTrue() {

        enumValues<PaymentType>().map { it.name }.forEach {
            val testURI = "myapp://payment/$it/1"
            val result = paymentURIChecker.matchOnlyValueWithInTheEnums(testURI)
            assertThat(result).isTrue()
        }

    }

    @Test
    fun matchOnlyValueWithInTheEnums__incorrectInput__ReturnsFalse() {


        val testURI = "myapp://payment/other/1"
        val result = paymentURIChecker.matchOnlyValueWithInTheEnums(testURI)
        assertThat(result).isFalse()


    }


}