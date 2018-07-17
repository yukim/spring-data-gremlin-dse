// Set up graph schema in DSE Graph
// Graph name: air_routes
system.graph("air_routes").ifNotExists().create()

// switch to air_routes graph
:remote config alias g air_routes.g

schema.propertyKey("dist").Int().single().ifNotExists().create()
schema.propertyKey("city").Text().single().ifNotExists().create()
schema.propertyKey("icao").Text().single().ifNotExists().create()
schema.propertyKey("runways").Int().single().ifNotExists().create()
schema.propertyKey("code").Text().single().ifNotExists().create()
schema.propertyKey("region").Text().single().ifNotExists().create()
schema.propertyKey("desc").Text().single().ifNotExists().create()
schema.propertyKey("type").Text().single().ifNotExists().create()
schema.propertyKey("longest").Int().single().ifNotExists().create()
schema.propertyKey("elev").Int().single().ifNotExists().create()
schema.propertyKey("country").Text().single().ifNotExists().create()
schema.propertyKey("lat").Double().single().ifNotExists().create()
schema.propertyKey("lon").Double().single().ifNotExists().create()

schema.vertexLabel("airport").partitionKey("code").properties("country", "longest", "city", "elev", "icao", "lon", "type", "region", "runways", "lat", "desc").ifNotExists().create()
schema.vertexLabel("version").partitionKey("code").properties("type", "desc").ifNotExists().create()
schema.vertexLabel("country").partitionKey("code").properties("type", "desc").ifNotExists().create()
schema.vertexLabel("continent").partitionKey("code").properties("type", "desc").ifNotExists().create()

schema.vertexLabel("airport").index("search").search().by("desc").add()

schema.edgeLabel("route").multiple().properties("dist").ifNotExists().create()
schema.edgeLabel("contains").multiple().ifNotExists().create()

schema.edgeLabel("route").connection("airport", "airport").add()
schema.edgeLabel("contains").connection("country", "airport").connection("continent", "airport").add()