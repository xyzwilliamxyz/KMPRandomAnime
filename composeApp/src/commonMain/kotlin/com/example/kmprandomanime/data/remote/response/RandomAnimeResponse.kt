package com.example.kmprandomanime.data.remote.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class RandomAnimeResponse(

	@SerialName("data")
	val data: Data? = null
) {
	@Serializable
	data class GenresItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class Broadcast(

		@SerialName("string")
		val string: String? = null,

		@SerialName("timezone")
		val timezone: String? = null,

		@SerialName("time")
		val time: String? = null,

		@SerialName("day")
		val day: String? = null
	)

	@Serializable
	data class Jpg(

		@SerialName("large_image_url")
		val largeImageUrl: String? = null,

		@SerialName("small_image_url")
		val smallImageUrl: String? = null,

		@SerialName("image_url")
		val imageUrl: String? = null
	)

	@Serializable
	data class ExplicitGenresItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class From(

		@SerialName("month")
		val month: Int? = null,

		@SerialName("year")
		val year: Int? = null,

		@SerialName("day")
		val day: Int? = null
	)

	@Serializable
	data class Trailer(

		@SerialName("embed_url")
		val embedUrl: String? = null,

		@SerialName("youtube_id")
		val youtubeId: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class Images(

		@SerialName("jpg")
		val jpg: Jpg? = null,

		@SerialName("webp")
		val webp: Webp? = null
	)

	@Serializable
	data class ThemesItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class Prop(

		@SerialName("string")
		val string: String? = null,

		@SerialName("from")
		val from: From? = null,

		@SerialName("to")
		val to: To? = null
	)

	@Serializable
	data class Aired(

		@SerialName("prop")
		val prop: Prop? = null,

		@SerialName("from")
		val from: String? = null,

		@SerialName("to")
		val to: String? = null,

		@SerialName("string")
		val string: String? = null
	)

	@Serializable
	data class Webp(

		@SerialName("large_image_url")
		val largeImageUrl: String? = null,

		@SerialName("small_image_url")
		val smallImageUrl: String? = null,

		@SerialName("image_url")
		val imageUrl: String? = null
	)

	@Serializable
	data class ProducersItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class TitlesItem(

		@SerialName("type")
		val type: String? = null,

		@SerialName("title")
		val title: String? = null
	)

	@Serializable
	data class DemographicsItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class LicensorsItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class Data(

		@SerialName("title_japanese")
		val titleJapanese: String? = null,

		@SerialName("favorites")
		val favorites: Int? = null,

		@SerialName("broadcast")
		val broadcast: Broadcast? = null,

		@SerialName("year")
		val year: Int? = null,

		@SerialName("rating")
		val rating: String? = null,

		@SerialName("scored_by")
		val scoredBy: Int? = null,

		@SerialName("title_synonyms")
		val titleSynonyms: List<String?>? = null,

		@SerialName("source")
		val source: String? = null,

		@SerialName("title")
		val title: String? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("trailer")
		val trailer: Trailer? = null,

		@SerialName("duration")
		val duration: String? = null,

		@SerialName("score")
		val score: Double? = null,

		@SerialName("themes")
		val themes: List<ThemesItem?>? = null,

		@SerialName("approved")
		val approved: Boolean? = null,

		@SerialName("genres")
		val genres: List<GenresItem?>? = null,

		@SerialName("popularity")
		val popularity: Int? = null,

		@SerialName("members")
		val members: Int? = null,

		@SerialName("title_english")
		val titleEnglish: String? = null,

		@SerialName("rank")
		val rank: Int? = null,

		@SerialName("season")
		val season: String? = null,

		@SerialName("airing")
		val airing: Boolean? = null,

		@SerialName("episodes")
		val episodes: Int? = null,

		@SerialName("aired")
		val aired: Aired? = null,

		@SerialName("images")
		val images: Images? = null,

		@SerialName("studios")
		val studios: List<StudiosItem?>? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("titles")
		val titles: List<TitlesItem?>? = null,

		@SerialName("synopsis")
		val synopsis: String? = null,

		@SerialName("explicit_genres")
		val explicitGenres: List<ExplicitGenresItem?>? = null,

		@SerialName("licensors")
		val licensors: List<LicensorsItem?>? = null,

		@SerialName("url")
		val url: String? = null,

		@SerialName("producers")
		val producers: List<ProducersItem?>? = null,

		@SerialName("background")
		val background: String? = null,

		@SerialName("status")
		val status: String? = null,

		@SerialName("demographics")
		val demographics: List<DemographicsItem?>? = null
	)

	@Serializable
	data class StudiosItem(

		@SerialName("name")
		val name: String? = null,

		@SerialName("mal_id")
		val malId: Int? = null,

		@SerialName("type")
		val type: String? = null,

		@SerialName("url")
		val url: String? = null
	)

	@Serializable
	data class To(

		@SerialName("month")
		val month: Int? = null,

		@SerialName("year")
		val year: Int? = null,

		@SerialName("day")
		val day: Int? = null
	)
}

