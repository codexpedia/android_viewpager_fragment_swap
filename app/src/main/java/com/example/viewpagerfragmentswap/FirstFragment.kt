package com.example.viewpagerfragmentswap

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.first_fragment.*

class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn.setOnClickListener {
            val trans = fragmentManager.beginTransaction()

            // We use the "root frame" defined in "root_fragment.xml" as the reference to replace fragment
            trans.replace(R.id.root_frame, SecondFragment())

            // The following lines allow us to add the fragment to the stack and return to it later, by pressing back
            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            trans.addToBackStack(null)
            trans.commit()
        }
    }
}