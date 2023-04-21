package com.chaudharynabin6.navigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chaudharynabin6.base.ui.InternalDeeplinkNavigation
import com.chaudharynabin6.navigationcomponent.data.User
import com.chaudharynabin6.navigationcomponent.databinding.Fragment1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: Fragment1Binding

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
    ): View {
        // Inflate the layout for this fragment
        binding = Fragment1Binding.inflate(inflater, container, false)
        binding.navigateToFragment2.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment2(
                User(
                    name = "Nabin Chaudhary",
                    id = 100
                )
            )
            findNavController().navigate(action)
        }
        binding.navigateToFragment3.setOnClickListener {
            val action = Fragment1Directions.actionFragment1ToFragment3(
                "Naresh"
            )
            findNavController().navigate(action)
        }
        binding.apply {
            navigateToNestedGraph1.setOnClickListener {
                val action = Fragment1Directions.actionFragment1ToNavigation2()
                findNavController().navigate(action)
            }

            navigateToNestedGraph2.setOnClickListener {
                val action = Fragment1Directions.actionFragment1ToNestedNavGraph2()
                findNavController().navigate(action)
            }
            save.setOnClickListener {
                this.text.text = this.editText.text
            }
        }

        binding.apply {
            navigateToHistory.setOnClickListener {
                val deepLink = InternalDeeplinkNavigation(requireContext()).HISTORY.toUri()
                findNavController().navigate(deepLink)
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
         * @return A new instance of fragment Fragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}