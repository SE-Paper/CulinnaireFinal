package culinairegrails

class Recipe {

    String name
    Integer rating
    Date dateCreated
    Date lastUpdate
    String description
    byte[] photo
    String video
    Person follower
    Boolean typical

    static hasMany = [posts: Post, quantities: Quantity, instructions: Instruction, votes: Vote]
    static belongsTo = [person: Person, country: Country, category: Category]
    static hasOne = [difficulty: Difficulty, duration: Duration]

    Recipe(){
        dateCreated = new Date()
        lastUpdate = new Date()
        rating = 1
    }

    static constraints = {
        name(nullable: false, minSize: 3)
        rating(nullable: false, range: 1..5)
        dateCreated(nullable: false)
        lastUpdate(nullable: false)
        photo(nullable: false, minSize: 1, maxSize: 4194304)
        description(nullable: false, blank: false, maxSize: 400)
        video(nullable: true, url: true)
        follower(nullable: true)
        typical(nullable: false)
    }

    static mapping = {
        posts cascade: "all-delete-orphan"
        sort rating: 'desc'
    }

    String toString(){
        "${name}"
    }
}
