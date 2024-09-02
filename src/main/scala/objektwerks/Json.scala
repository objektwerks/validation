package objektwerks

type JsonObject = String
def JsonObject(json: String): JsonObject = json

type JsonObjects = Seq[JsonObject]
def JsonObjects(jsonObjects: JsonObject*): Seq[JsonObject] = Seq(jsonObjects*)

final case class Json(jsonObjects: JsonObjects)