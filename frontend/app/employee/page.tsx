"use client"
import * as React from 'react';
import { useState } from 'react';
import { TextField, FormControl, Box, Alert, Typography } from '@mui/material';
import axios from 'axios';
import { ok } from 'assert';
import CustomButton from '@/Components/CustomButton';
import CustomizedTables from '@/Components/Table';

export default function YourComponent() {
  const [formData, setFormData] = useState({
    ssn: '',
    role: '',
    salary: '',
  });
  const [error, setError] = useState(false)
  const [success, setSuccess] = useState(false)
  const [data, setData] = useState([])

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
    console.log(formData)
  };

  const addEmployeeData = async () => {
    try {
      const response = await axios.post("http://localhost:8080/api/addemployee", formData);
      setData(response.data);
      if (response.status === 201) {
        setSuccess(true);
        setError(false);
      } else {
        setSuccess(false);
        setError(true);
      }
    } catch (error) {
      setError(true);
      setSuccess(false);
    }
  };
  return (
    <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent:'center' }}>
     <div className='p-24 flex flex-col gap-8 justify-center w-[70%]'>
    <Typography variant='h6'>Add Employee details to the Employees table</Typography>
    <FormControl sx={{ display: 'flex', flexDirection: 'column', gap: '20px' }}>
      <TextField
        required
        id="outlined-required-ssn"
        label="SSN"
        type="number"
        name="ssn"
        value={formData.ssn}
        onChange={handleChange}
      />
      <TextField
        required
        id="outlined-required-role"
        label="Role"
        type="text"
        name="role"
        value={formData.role}
        onChange={handleChange}
      />
      <TextField
        required
        id="outlined-required-salary"
        label="Salary"
        type="number"
        name="salary"
        value={formData.salary}
        onChange={handleChange}
      />
<CustomButton name="Submit" onClick={addEmployeeData}/>
        </FormControl>
        <CustomizedTables data = {data}/>
        {error? <Alert severity="error"> Not able to add data, please try again </Alert>: null}
        {success? <Alert severity="success">Data added successfully</Alert>: null}
    </div>
    </Box>
  );
}
