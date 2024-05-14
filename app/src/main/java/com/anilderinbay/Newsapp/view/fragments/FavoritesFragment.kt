package com.anilderinbay.Newsapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anilderinbay.Newsapp.R
import com.anilderinbay.Newsapp.adapter.NewsAdapter
import com.anilderinbay.Newsapp.databinding.FragmentFavoritesBinding
import com.anilderinbay.Newsapp.model.response.NewsResponse
import com.anilderinbay.Newsapp.util.Constants
import com.orhanobut.hawk.Hawk

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var binding: FragmentFavoritesBinding
    private var newsAdapter = NewsAdapter()

    var savedList: ArrayList<NewsResponse.Article> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvFavoritesList.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            rvFavoritesList.adapter = newsAdapter

            (Hawk.get(Constants.FAVORITE_LIST) as? ArrayList<NewsResponse.Article>)?.let {
                newsAdapter.setItems(it)
            }

            newsAdapter.newsItemClickListener = {
                findNavController().navigate(R.id.action_favoritesFragment_to_detailsFragment,
                    bundleOf("detail" to it))

            }
        }

        newsAdapter.favoritesItemClickListener = {

            findNavController().navigate(R.id.action_favoritesFragment_to_detailsFragment)

        }



    }
}