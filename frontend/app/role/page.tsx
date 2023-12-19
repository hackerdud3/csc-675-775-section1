"use client"
import * as React from 'react';
import Box from '@mui/material/Box';
import IconButton from '@mui/material/IconButton';
import Input from '@mui/material/Input';
import FilledInput from '@mui/material/FilledInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormHelperText from '@mui/material/FormHelperText';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import { Alert, Button, Typography } from '@mui/material';
import CustomButton from '@/Components/CustomButton';
import CustomizedTables from '@/Components/Table';
import axios from 'axios';


export default function InputAdornments() {
  const [showPassword, setShowPassword] = React.useState(false);
  const [data, setData] = React.useState([]);
  const [value, setValue] = React.useState(0);
  const [error, setError] = React.useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
  };

  const fetchCompanies = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/salary?inputValue=${value}`);
      setData(response.data); // Set the fetched data to state
      if(response.data.length === 0){
        setError(true)
      }else{
        setError(false)
      }
      console.log(response.data); // Log the fetched data for verification
    } catch (error) {
      setError(true);
    }
  };
  

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const inputValue = parseFloat(event.target.value);
    setValue(isNaN(inputValue) ? 0 : inputValue); // Update the state with a number or default to 0 if NaN
  };
  return (
    <Box sx={{ display: 'flex', flexWrap: 'wrap', justifyContent:'center' }}>
       <div className='p-24 flex flex-col gap-8 justify-center w-[70%]'>
    <Typography variant='h6'>Find role of the employees with salary greater than or equal to the input value</Typography>
        <FormControl>
          <InputLabel htmlFor="outlined-adornment-amount">Amount</InputLabel>
          <OutlinedInput
            id="outlined-adornment-amount"
            startAdornment={<InputAdornment position="start">$</InputAdornment>}
            label="Amount"
            type='number'
            onChange={handleChange}
          />
         <CustomButton name="Submit" onClick={fetchCompanies}/>
        </FormControl>
        <CustomizedTables data = {data}/>
        {error? <Alert severity="error">No data found</Alert>: null}
       
        
      </div>
    </Box>
  );
}