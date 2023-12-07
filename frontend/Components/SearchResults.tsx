import { List, ListItem, ListItemText } from '@mui/material';
import React from 'react';

type Props = {
  results: { companies: any[]; employees: any[] };
};

const SearchResults = (props: Props) => {
  return (
    <List disablePadding>
      {props.results?.companies?.map((item: any) => (
        <ListItem key={item.id} disablePadding>
          <ListItemText primary={`${item.name}`} secondary={`Revenue: ${item.revenue}`}/>
        </ListItem>
      ))}
      {props.results?.employees?.map((item: any) => (
        <ListItem key={item.ssn} disablePadding>
         <ListItemText
  primary={`SSN: ${item.ssn}`}
  secondary={`Role: ${item.role}, Salary: ${item.salary}`}
/>

        </ListItem>
      ))}
    </List>
  );
};

export default SearchResults;
