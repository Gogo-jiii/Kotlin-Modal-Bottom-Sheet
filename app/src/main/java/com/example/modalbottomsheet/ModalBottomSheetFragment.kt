package com.example.modalbottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheetFragment : BottomSheetDialogFragment() {

    var listView: ListView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.bottom_sheet_view, container, false)
        listView = view.findViewById(R.id.listview)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val options = ArrayList<String?>()
        options.add("One")
        options.add("Two")
        options.add("Three")
        options.add("Four")
        options.add("Five")
        val adapter: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(), android.R.layout.simple_list_item_1, options as List<Any?>
        )
        listView!!.adapter = adapter
        listView!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            Toast.makeText(parent.context, options[position], Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}