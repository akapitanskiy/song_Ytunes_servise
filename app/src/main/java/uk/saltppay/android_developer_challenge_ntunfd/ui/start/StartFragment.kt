package uk.saltppay.android_developer_challenge_ntunfd.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import uk.saltppay.android_developer_challenge_ntunfd.R
import uk.saltppay.android_developer_challenge_ntunfd.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _bind: FragmentStartBinding? = null
    private val bind get() = _bind!!

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bind = FragmentStartBinding.inflate(inflater, container, false)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        bind.startButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.songListFragment)
        }

        return bind.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        _bind = null
    }
}