package com.cafrecode.writersplanx.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cafrecode.writersplanx.databinding.FragmentNotificationsBinding
import com.cafrecode.writersplanx.db.Message
import com.cafrecode.writersplanx.di.Injectable
import javax.inject.Inject

class NotificationsFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: NotificationsViewModel by viewModels {
        viewModelFactory
    }

    lateinit var binding: FragmentNotificationsBinding

    val adapter =
        NotificationsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationsBinding.inflate(inflater)
        binding.list.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.list().observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                adapter.messages = it as ArrayList<Message>
                binding.content.visibility = View.GONE
            }
        })
    }
}