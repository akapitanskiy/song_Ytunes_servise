package uk.saltppay.android_developer_challenge_ntunfd.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import uk.saltppay.android_developer_challenge_ntunfd.data.db.ItunesDao
import uk.saltppay.android_developer_challenge_ntunfd.data.db.ItunesDatabase
import uk.saltppay.android_developer_challenge_ntunfd.utils.Const
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModuleProvider(private val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideItunesRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(Const.ITUNES_API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDb(context: Context): ItunesDatabase {
        return Room.databaseBuilder(
            context,
            ItunesDatabase::class.java,
            ItunesDatabase.ITUNES_DB_FILE_NAME
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    @Singleton
    @Provides
    fun provideItunesDao(db: ItunesDatabase): ItunesDao {
        return db.getItunesDao()
    }


}