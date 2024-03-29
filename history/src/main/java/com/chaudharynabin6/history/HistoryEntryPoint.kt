package com.chaudharynabin6.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chaudharynabin6.base.ui.User
import com.chaudharynabin6.history.databinding.FragmentHistoryEntryPointBinding
import com.google.common.io.BaseEncoding
import com.google.gson.Gson

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryEntryPoint.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryEntryPoint : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentHistoryEntryPointBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHistoryEntryPointBinding.inflate(layoutInflater, container, false)

        binding.apply {
            btnNavigateToListing.setOnClickListener {


                val gson = Gson()
                val user = User(
                    """
                    hello\uD83E\uDD23**%#{dfsdkjfeoik'$'}(*\"\\!#${'$'}%&/()[]{}=-+'^,.;:_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567899)}*(j)j21kfjdk..-Kg%"{wW:..~~~~ \\"""".trimIndent(),
                    1
                )

//                val userJson = Json.encodeToString(user)

                val userJson = Gson().toJson(user)

                val userString =
                    "hello\\uD83E\\uDD23**%#{dfsdkjfeoik'\$'}(*9)}*(j)j21kfjdk....~~~~ \\\\\""
                val userByteArray = userString.toByteArray()

                val base32Encoded = BaseEncoding.base64Url().encode(userJson.encodeToByteArray())


                // https://github.com/google/gson/issues/2244
                // https://stackoverflow.com/questions/71988144/serializer-for-class-is-not-found-mark-the-class-as-serializable-or-prov


//                val serializedUser = gson.toJson(user)
                val deepLinkURI = "myapp://listing?user=${
                    base32Encoded
                }".toUri()


                findNavController().navigate(
                    deepLinkURI
                )
            }
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryEntryPoint.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryEntryPoint().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}