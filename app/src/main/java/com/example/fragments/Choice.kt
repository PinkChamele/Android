package com.example.fragments
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId;

open class Choice(
    @PrimaryKey var _id: ObjectId = ObjectId(),
    var _partition: String = "123",
    var firm: String = "",
    var type: String = ""
): RealmObject() {}