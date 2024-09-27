import mysql from 'mysql2';
import config from './db_config';
import crypto from 'crypto';

const config = {
    host: process.env.DB_HOST || "localhost",
    user: process.env.DB_USER || "root",
    password: process.env.DB_PASSWORD || "password",
    database: process.env.DB_DATABASE || "events",
}

const connection = mysql.createConnection(config);
connect();

function connect() {
    connection.connect((err) => {
        if (err) {
            console.error('Error connecting to database: ', err);
            throw err;
        }
        console.log('Connected to database');
    });
}

async function getCategories() {
    const query = `SELECT DISTINCT Category FROM Activities'`;
    const [rows, fields] = await connection.promise().query(query);
    return rows;
}

async function getEvents(category) {
    const query = `SELECT * FROM Activities WHERE Category = ?`;
    const [rows, fields] = await connection.promise().query(query, [category]);
    return rows;
}

async function joinEvent(id) {
    const query = `UPDATE Activities SET NumberOfPeople = NumberOfPeople + 1 WHERE ID = ?`;
    await connection.promise().query(query, [id]);
}

async function addEvent(category, activity, dateTime, location, numberOfPeople) {
    const query = `INSERT INTO Activities (Category, Activity, DateTime, Location, NumberOfPeople) VALUES (?, ?, ?, ?, ?)`;
    await connection.promise().query(query, [category, activity, dateTime, location, numberOfPeople]);
}

export { getCategories, getEvents, joinEvent, addEvent};