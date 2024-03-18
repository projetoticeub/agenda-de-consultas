CREATE TABLE consultas (
    id SERIAL PRIMARY KEY,
    paciente_id BIGINT REFERENCES pacientes(id),
    data TIMESTAMP
);
