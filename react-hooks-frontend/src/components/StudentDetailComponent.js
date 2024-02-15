import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import StudentService from '../services/StudentService';

const StudentDetailComponent = () => {
    const { id } = useParams();
    const [student, setStudent] = useState(null);

    useEffect(() => {
        StudentService.getStudentById(id)
            .then(response => {
                setStudent(response.data);
            })
            .catch(error => {
                console.log(error);
            });
    }, [id]);

    if (!student) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>Student Details</h2>
            <p>Name: {student.firstName}</p>
            <p>Age: {student.lastName}</p>
            <p>Grade: {student.grade}</p>
        </div>
    );
};

export default StudentDetailComponent;
