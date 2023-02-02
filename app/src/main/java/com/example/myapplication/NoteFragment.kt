package com.example.myapplication

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    fun sizeText(size: Float): Float {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, metrics)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val editButton = Button(requireContext()).apply {
            text = "Edit"
            id = View.generateViewId()
        }
        val nameView = TextView(context).apply{
            setText(R.string.name_place_holder)
            textSize = sizeText(7f)
        }
        val dateView = TextView(context).apply{
            setText(R.string.date_place_holder)
            textSize = sizeText(7f)

        }
        val descView = TextView(context).apply{
            setText(R.string.desc_place_holder)
            textSize = sizeText(7f)
        }
        val nameLinearLayout = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                120,
                0.2f
            )
            // Add the ImageView to the layout.
            addView(nameView)
        }
        val dateLinearLayout = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                120,
                0.2f
            )
            // Add the ImageView to the layout.
            addView(dateView)
        }
        val descLinearLayout = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                120,
                0.2f
            )
            // Add the ImageView to the layout.
            addView(descView)
        }
        val leftWrapper = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.WHITE)
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                0.2f

            )

            addView(nameLinearLayout)
            addView(dateLinearLayout)
            addView(descLinearLayout)
        }
        val rightWrapper = LinearLayoutCompat(requireContext()).apply {
            setBackgroundColor(Color.WHITE)
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                0.8f
            )
            addView(editButton)
        }

       val linearLayout = LinearLayoutCompat(requireContext()).apply {
           setBackgroundColor((Color.WHITE))
           layoutParams = LinearLayoutCompat.LayoutParams(
               LinearLayoutCompat.LayoutParams.MATCH_PARENT,
               LinearLayoutCompat.LayoutParams.MATCH_PARENT,
           )
           weightSum = 1.0f
           addView(leftWrapper)
           addView(rightWrapper)
       }

        return linearLayout
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}