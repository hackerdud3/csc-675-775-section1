import { Button, ButtonProps } from '@mui/material';
import React from 'react';

type Props = {
  name: string;
  // You can add more props here if needed
} & ButtonProps;

const CustomButton: React.FC<Props> = ({ name, ...buttonProps }) => {
  const buttonStyle = {
    color: 'black',
    backgroundColor: 'primary', // Assuming 'primary' is a valid color variable or string
    '&:hover': {
      color: 'white' 
    },
  };

  return (
    <Button sx={{  marginTop: '18px',
    }} variant='contained' style={buttonStyle} {...buttonProps}>
      {name}
    </Button>
  );
};

export default CustomButton;
