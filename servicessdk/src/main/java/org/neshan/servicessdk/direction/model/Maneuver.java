package org.neshan.servicessdk.direction.model;

import com.google.gson.annotations.SerializedName;

/**
 * contains the action to take for the current {@link DirectionStep} (turn left, merge, straight, etc.).
 * This field is used to determine which icon to display, and can contain one of the following values:
 * right, slight-right, sharp-right, left, sharp-left, ururn, straight, exit-rotary, arrive, depart
 */
public enum Maneuver {

    @SerializedName("right") RIGHT,
    @SerializedName("slight-right") SLIGHT_LIGHT ,
    @SerializedName("sharp-right") SHARP_RIGHT ,
    @SerializedName("left") LEFT ,
    @SerializedName("sharp-left") SHARP_LEFT ,
    @SerializedName("ururn") UTURN ,
    @SerializedName("straight") STARIGHT ,
    @SerializedName("exit-rotary") EXIT_ROTARY ,
    @SerializedName("arrive") ARRIVE ,
    @SerializedName("depart") DEPART ;


}
