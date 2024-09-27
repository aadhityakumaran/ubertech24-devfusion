import { Router } from "express";
import { getCategories, getEvents, addEvent, joinEvent } from "../db_connect.js";
const router = Router();

router.get("/categories", (req, res) => {
    res.json(getCategories());
});

router.get("/events", (req, res) => {
    const category = req.query.category;
    res.json(getEvents(category));
});

router.post("/events", (req, res) => {
    const { category, activity, dateTime, location, numberOfPeople } = req.body;
    addEvent(category, activity, dateTime, location, numberOfPeople);
    res.json({ message: "Event added successfully" });
});

router.put("/events/:id", (req, res) => {
    const id = req.params.id;
    joinEvent(id);
    res.json({ message: "Event joined successfully" });
});

export default router;
