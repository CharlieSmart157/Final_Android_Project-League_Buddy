package com.example.charlie.finalproject_leaguebuddy.Utility;

/**
 * Created by Charlie on 09/06/2016.
 */
public class Constants {

public static final String BASE_URL = "https://euw.api.pvp.net";

public static final String STATIC_DATA_BASE_URL = "https://global.api.pvp.net";

public static final String SUMMONER_BY_NAME_URL = "/api/lol/euw/v1.4/summoner/by-name/{summonerName}?";

public static final String SUMMONER_URL_BY_ID_URL = "/api/lol/euw/v1.4/summoner/{summonerIds}?";

public static final String API_KEY = "api_key=4461e7ac-4ba0-41e6-8ed1-496bf913da49";

public static final String DDRAGON_IMG_URL = "http://ddragon.leagueoflegends.com/cdn/6.13.1/img/profileicon/";

public static final String DDRAGON_CHAMP_IMG_URL = "http://ddragon.leagueoflegends.com/cdn/6.13.1/img/champion/";

public static final String SUMMONER_RANKED_LEAGUE_URL = "/api/lol/euw/v2.5/league/by-summoner/{summonerIds}/entry?";

public static final String SUMMONER_CHAMPION_MASTERY_URL = "/championmastery/location/EUW1/player/{summonerIds}/topchampions?count=3&";

public static final String CHAMPION_STATIC_INFO_URL = "/api/lol/static-data/euw/v1.2/champion/{champId}?champData=image&";

public static final String RANKED_STATS_URL = "/api/lol/euw/v1.3/stats/by-summoner/{summonerIds}/ranked?season=SEASON2016&";
}
