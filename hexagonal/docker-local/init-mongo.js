db = db.getSiblingDB('hexagonal');

db.createUser({
    user: "root",
    pwd: "example",
    roles: [
        {
            role: "readWrite",
            db: "hexagonal"
        }
    ]
});
