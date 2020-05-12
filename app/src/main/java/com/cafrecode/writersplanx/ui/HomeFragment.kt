package com.cafrecode.writersplanx.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cafrecode.writersplanx.databinding.FragmentHomeBinding
import com.cafrecode.writersplanx.db.Message
import com.cafrecode.writersplanx.di.Injectable
import javax.inject.Inject

const val TAG = "HomeFragment"

class HomeFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding: FragmentHomeBinding

    val adapter = HomeAdapter()

    val viewModel: HomeViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.list.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.list().observe(viewLifecycleOwner, Observer {
            Log.i(TAG, "data: $it")
            if (it.isNotEmpty()) {
                adapter.messages = it as ArrayList<Message>
                binding.content.visibility = View.GONE
            }
        })
    }
}