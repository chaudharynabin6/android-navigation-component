package com.chaudharynabin6.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.chaudharynabin6.navigationcomponent.databinding.FragmentNested21Binding
import com.chaudharynabin6.navigationcomponent.databinding.FragmentNested22Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Nested_2_2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Nested_2_2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding : FragmentNested22Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNested22Binding.inflate(inflater,container,false)
        binding.apply {
            navigateBackToFragment1.setOnClickListener {
                val action = Nested_2_2Directions.actionGlobalNested2Fragment1NestedNavGraph()
                findNavController().navigate(action)
            }
            navigateBackToFragment2.setOnClickListener {
                val action = NestedNavGraphDirections.actionGlobalNested2Fragment2NestedNavGraph()
                findNavController().navigate(action)
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
         * @return A new instance of fragment Nested_2_2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Nested_2_2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}