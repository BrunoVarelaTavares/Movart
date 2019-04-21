package com.devwithbruno.www.movart.di.module;


import dagger.Module;

/**
 * Created by Bruno on 15/02/2018.
 */

@Module
public class DatabaseModule {

    public static final String DATABASE = "database_name";
    public static final String DATABASE_TV = "tv_database_name";

//    @Provides
//    @Named(DATABASE)
//    String provideDatabaseName(){
//        return Config.MOVIES_TABLE_NAME;
//    }
//
//
//    @Provides
//    @Named(DATABASE_TV)
//    String provideTvDatabaseName(){
//        return Config.MOVIES_TABLE_NAME;
//    }
//
//
//    @Provides
//    //@Singleton// Mudei aqui estava context em vez de AppCompatActivity
//    PopularMoviesDb providePopularMoviesDao(AppCompatActivity context, @Named(DATABASE) String databaseName){
//        return Room.databaseBuilder(context,PopularMoviesDb.class, databaseName).build();
//    }
//
//
//
//
//
//    @Provides
//    UpcomingMoviesDb provideUpcomingMoviesDb(AppCompatActivity activity, @Named(DATABASE) String databaseName){
//        return Room.databaseBuilder(activity, UpcomingMoviesDb.class, databaseName).build();
//    }
//
//
//    @Provides
//        //@Singleton// Mudei aqui estava context em vez de AppCompatActivity
//    PopularTvDb providePopularTvDb(AppCompatActivity context, @Named(DATABASE_TV) String databaseName){
//        return Room.databaseBuilder(context,PopularTvDb.class, databaseName).build();
//    }
//
//
//
//    @Provides
//   // @Singleton
//    PopularMoviesDao provideMoviesDao(PopularMoviesDb popularMoviesDb){
//        return popularMoviesDb.popularMoviesDao();
//    }
//
//
//
//    @Provides
//    UpcomingMoviesDao provideUpcomingMoviesDao(UpcomingMoviesDb upcomingMoviesDb){
//        return upcomingMoviesDb.upcomingMoviesDao();
//    }
//
//
//    @Provides
//    PopularTvDao providePopularTvDao(PopularTvDb popularTvDb){
//        return popularTvDb.getPopularTvDao();
//    }


}