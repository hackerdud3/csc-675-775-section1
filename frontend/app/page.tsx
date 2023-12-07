import ButtonCard from '@/Components/ButtonCard';
import { Button } from '@mui/material';
import Image from 'next/image'
import Link from 'next/link';


export default function Home() {

  const queries = [{
    name:"Find Companies Profit",
    description:"Find the names of companies and their profits (calculated by subtracting operational cost from revenue) where the profit is greater than Input value.",
    href: "/profits"
  }, 
  {
    name:"Find Employees Role",
    description:"Find the role of employees, the maximum salary within each role, and the average salary for each role. The results are grouped by the employee's role, and only those groups are included where the average salary is greater than or equal to 60,000.",
    href: "/role"
  }, 
  {
    name:"Find Products and purchase quantity",
    description:"Find the names of products and their total purchase quantity (across all customers) where the total purchase quantity is greater than 2.",
    href: "/purchases"
  }, 
  {
    name:"Find Role and Salary",
    description:"Find the role and salary of employees where there exists at least one other employee who is a developer and has a salary less than the salary of the first employee.",
    href: "/salary"
  }, 
]
  return (
    <main className="flex w-full items-start gap-8 p-24 flex-wrap">
      {
        queries.map( (item, index) =>(
          <Link href={item.href}>
          <ButtonCard key={index} name = {item.name} description = {item.description} />
          </Link>
        ))
      }
    </main>
  )
}
