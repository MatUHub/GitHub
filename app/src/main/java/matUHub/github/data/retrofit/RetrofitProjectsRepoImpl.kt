package matUHub.github.data.retrofit

import io.reactivex.rxjava3.core.Single
import matUHub.github.domain.GitProjectEntity
import matUHub.github.domain.ProjectsRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProjectsRepoImpl : ProjectsRepo {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)


    /*override fun observeReposForUser(username: String): Single<List<GitProjectEntity>> {
        return Single.create { emitter ->
            api.listRepos(username)
                .enqueue(object : Callback<List<GitProjectEntity>> {
                    override fun onResponse(
                        call: Call<List<GitProjectEntity>>,
                        response: Response<List<GitProjectEntity>>
                    ) {
                        emitter.onSuccess(response.body())
                    }

                    override fun onFailure(call: Call<List<GitProjectEntity>>, t: Throwable) {
                        emitter.onError(t)
                    }
                })
        }
    }*/


override fun getRepoUsers(): Single<List<GitProjectEntity>> {
    return Single.create { emitter ->
        api.listRepos("MatUHab")
            .enqueue(object : Callback<List<GitProjectEntity>> {
                override fun onResponse(
                    call: Call<List<GitProjectEntity>>,
                    response: Response<List<GitProjectEntity>>
                ) {
                    emitter.onSuccess(response.body())
                }

                override fun onFailure(call: Call<List<GitProjectEntity>>, t: Throwable){
                    emitter.onError(t)
                }

            })
    }
}
}