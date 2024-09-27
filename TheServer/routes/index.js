import { Router } from "express";
import { getCategories, getEvents, addEvent, joinEvent } from "../db_connect.js";
const router = Router();

router.get("/categories", async (req, res) => {
    res.json(await getCategories());
});

router.get("/events", async (req, res) => {
    const category = req.query.category;
    res.json(await getEvents(category));
});

router.post("/events", async (req, res) => {
    const { category, activity, dateTime, location } = req.body;
    const date = new Date(Number(dateTime));
    const mysqlDateTime = date.toISOString().slice(0, 19).replace("T", " ");
    try {
        await addEvent(category, activity, mysqlDateTime, location);
        res.json({ message: "Event added successfully" });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: "Failed to add event" });
    }
});

router.put("/events/:id", async (req, res) => {
    const id = req.params.id;
    try {
        await joinEvent(id);
        res.json({ message: "Event joined successfully" });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: "Failed to join event" });
    }
});

export default router;
