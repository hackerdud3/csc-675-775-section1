
import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';

type Props = {
    name: String
    description: String
}

export default function ButtonCard(props: Props) {
  return (
    <Card sx={{ width:350, height:200 }}>
      <CardActionArea sx={{height:"100%", display:'flex', flexDirection:"column", justifyContent:"start", alignItems:"center"}}>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {props.name}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {props.description}
          </Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}