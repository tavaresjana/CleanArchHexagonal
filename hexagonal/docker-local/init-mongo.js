db = db.getSiblingDB('hexagonal');

db.createUser({
    user: "root",
    pwd: "root",
    roles: [
        {
            role: "readWrite",
            db: "hexagonal"
        }
    ]
});
