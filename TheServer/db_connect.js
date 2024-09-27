import mysql from 'mysql2';
import config from './db_config';
import crypto from 'crypto';

const config = {
    host: process.env.DB_HOST || "localhost",
    user: process.env.DB_USER || "root",
    password: process.env.DB_PASSWORD || "4971",
    database: process.env.DB_DATABASE || "blood",
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

function hashPassword(password) {
    const hash = crypto.createHash('sha256');
    hash.update(password);
    return hash.digest('hex');
}