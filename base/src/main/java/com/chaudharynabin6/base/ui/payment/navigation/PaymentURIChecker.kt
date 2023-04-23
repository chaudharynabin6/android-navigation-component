package com.chaudharynabin6.base.ui.payment.navigation

import android.content.Context
import com.chaudharynabin6.base.R

class PaymentURIChecker(private val context: Context) {
    //    https://base64.guru/standards/base64url
    fun matchAnyBase64URLSafeURI(inputURI: String): Boolean {
        val placeholderURI = context.getString(R.string.deeplink_payment_entrypoint)
        var replacedURI = placeholderURI.replace("{id}", "-?\\d+")
        replacedURI = replacedURI.replace("{paymentType}", "[A-Za-z0-9_-]*\\")
        val regex = Regex(replacedURI)
        return regex.matches(inputURI)
    }

    fun matchOnlyValueWithInTheEnums(inputURI: String): Boolean {

        val placeholderURI = context.getString(R.string.deeplink_payment_entrypoint)
        var replacedURI = placeholderURI.replace("{id}", "-?\\d+")
        val enumValues = enumValues<PaymentType>().map { it.name }
        val regexReplacer = enumValues.joinToString(separator = "|", prefix = "(", postfix = ")")
        replacedURI = replacedURI.replace("{paymentType}", regexReplacer)
        val regex = Regex(replacedURI)
        return regex.matches(inputURI)
    }
}