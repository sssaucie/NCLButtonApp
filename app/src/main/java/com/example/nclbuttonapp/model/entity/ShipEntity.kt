package com.example.nclbuttonapp.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShipEntity(
    val shipName: String,
    val code: String,
    val allowedGuestCount: Int,
    val shipDescription: String,
    val shipDescriptionHtml: String,
    val accessCode: String,
    val wesbCode: String,
    val recategorizationDate: String,
    val recategorizationDefaultView: String,
    val name: String,
    val storiesHeadlineHtml: String?,
    val answersHeadlineHtml: String?,
    val legends: List<Legend>,
    val shipFacts: ShipFacts,
    val whatsIncluded: List<String>,
    val highlights: List<String>,
    val features: String,
    val imagePath: List<String>,
    val videoList: List<String>,
    val stateroomMetas: List<StateroomMeta>,
    val bgeImagePath: String,
    val onboard_phones: List<OnboardPhone>
) : Parcelable

@Parcelize
data class Legend(
    val legendWeight: String,
    val name: String,
    val description: String,
    val legendImageLink: String
) : Parcelable

@Parcelize
data class ShipFacts(
    val passengerCapacity: String?,
    val grossRegisterTonnage: String,
    val overallLength: String,
    val maxBeam: String,
    val draft: String,
    val engines: String,
    val cruiseSpeed: String,
    val crew: String?,
    val inauguralDate: String?,
    val remodeledDate: String?
) : Parcelable

@Parcelize
data class StateroomMeta(
    val categorizationVersion: String,
    val name: String,
    val code: String,
    val accessCode: String,
    val description: String,
    val shortDescription: String,
    val genericCode: String,
    val includedFeatures: List<String>,
    val thumbnailImage: String?,
    val floorPlanLink: String?,
    val view360Link: String?,
    val imagePath: List<String>,
    val videoList: List<String>,
    val weight: String,
    val features_highlights: String,
    val featureHighlights: String,
    val overview_image: OverviewImage,
    val stateroomSubMetas: List<StateroomSubMeta>
) : Parcelable

@Parcelize
data class OnboardPhone(
    val name: String,
    val mobileName: String,
    val token: String,
    val phone: String,
    val locationSharingEnabled: Boolean,
    val venueCode: String
) : Parcelable

@Parcelize
data class OverviewImage(
    val imagePath: String,
    val title: String,
    val alt: String
) : Parcelable

@Parcelize
data class StateroomSubMeta(
    val name: String,
    val code: String,
    val accessCode: String,
    val description: String,
    val body: String,
    val imageLinks: List<ImageLink>,
    val videoList: List<String>,
    val featuresAndHighlights: String,
    val occupancy: String,
    val approximateSize: String,
    val view360Link: String?,
    val featuredTag: String?,
    val featuredTagDescription: String?,
    val marketingTagLine: String,
    val floorPlanLink: String?,
    val guaranteeMessage: String,
    val thumbnailImage: String?,
    val balconySize: String?,
    val stateroomCategories: List<StateroomCategory>
) : Parcelable

@Parcelize
data class ImageLink(
    val imageHeadLine: String,
    val legendWeight: String,
    val imageLink: String
) : Parcelable

@Parcelize
data class StateroomCategory(
    val name: String,
    val code: String,
    val description: String?,
    val comment: String,
    val positionInShip: String,
    val colorSwatch: String,
    val decks: String,
    val mandatoryCabin: Boolean,
    val upsellStateroomCategory: String?,
    val categoryID: String
) : Parcelable