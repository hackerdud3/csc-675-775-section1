import { List, ListItem, ListItemText } from '@mui/material';
import React from 'react';

type Props ={
    results: any
}
const SearchResults = (props: Props) => {
  return (
    <ul>
      {props.results.map((company:any) => (
        <List disablePadding>
            <ListItem disablePadding>
            <ListItemText key={company.id} primary = {company.name}/>
            </ListItem>
        </List>
       
      ))}
    </ul>
  );
};

export default SearchResults;
