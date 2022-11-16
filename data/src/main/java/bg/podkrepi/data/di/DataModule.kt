package bg.podkrepi.data.di

import android.content.Context
import android.content.res.Resources
import bg.podkrepi.data.BuildConfig
import bg.podkrepi.data.R
import bg.podkrepi.data.adapters.AlwaysSerializeNullsFactory
import bg.podkrepi.data.adapters.DateTimeMoshiAdapter
import bg.podkrepi.data.adapters.UnixTimestampMoshiAdapter
import bg.podkrepi.data.api.PodkrepiBGApi
import bg.podkrepi.data.campaigns.CampaignsRepositoryImpl
import bg.podkrepi.domain.campaigns.CampaignsRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindCampaignsRepository(impl: CampaignsRepositoryImpl): CampaignsRepository

    companion object {
        private const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MB

        @Provides
        fun provideResources(@ApplicationContext context: Context) = context.resources

        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) BODY else NONE
            }

        @Provides
        fun provideMoshi(): Moshi = Moshi.Builder()
            .add(DateTimeMoshiAdapter)
            .add(UnixTimestampMoshiAdapter)
            .add(AlwaysSerializeNullsFactory)
            .add(KotlinJsonAdapterFactory())
            .build()

        @Provides
        fun provideOkHttpClient(
            httpLoggingInterceptor: HttpLoggingInterceptor,
        ): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            resources: Resources,
            moshi: Moshi
        ): Retrofit {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(resources.getString(R.string.backend_url))
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
        }

        @Provides
        @Singleton
        fun provideApi(retrofit: Retrofit) = retrofit.create(PodkrepiBGApi::class.java)
    }
}
