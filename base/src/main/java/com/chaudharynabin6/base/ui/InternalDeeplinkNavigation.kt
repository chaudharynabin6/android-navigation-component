package com.chaudharynabin6.base.ui

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import com.chaudharynabin6.base.R
import com.chaudharynabin6.base.ui.payment.navigation.PaymentType


class InternalDeeplinkNavigation(
    private val context: Context,
) {

    val DOMAIN = "myapp://"
    val HISTORY =
        context.getString(R.string.deeplink_history_entrypoint)
    val LISTING =
        context.getString(R.string.deeplink_listing_entrypoint)
    val PAYMENT =
        context.getString(R.string.deeplink_payment_entrypoint)
    val SHOPPIINGCART =
        context.getString(R.string.deeplink_shopping_entry_point)

    fun makeCustomDeepLink(id: String): String {
        return "${DOMAIN}customDeepLink?id=${id}"
    }

    fun constructPaymentURI(paymentType: PaymentType, id: Int): Uri {
        return PAYMENT.replace("{id}", id.toString()).replace("{paymentType}", paymentType.name)
            .toUri()
    }

}