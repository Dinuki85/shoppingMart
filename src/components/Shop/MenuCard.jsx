import { Accordion, AccordionDetails, AccordionSummary, Checkbox, FormControlLabel, FormGroup, Typography } from '@mui/material'
import React from 'react'
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';



const demo = [
    {
        category: "250g",
        ingrediants: ["Basmathi"]

    },
    {
        category: "500g",
        ingrediants: ["Red Rice", "wild rice"]
    },

    {
        category: "2kg",
        ingrediants: ["Japan Rice", "Basmathi", "Red Rice"]
    }
]

const MenuCard = () => {
    return (
        <Accordion>
            <AccordionSummary
                expandIcon={<ExpandMoreIcon />}
                aria-controls="panel1-content"
                id="panel1-header"
            >
                <Typography component="span">
                    <div className='items-center justify-between lg:flex'>
                        <div className='items-center lg:flex lg:gap-5' >
                            <img
                                className='w-[7rem] h-[7rem] object-cover'
                                src="https://images.pexels.com/photos/1311771/pexels-photo-1311771.jpeg"
                                alt="" />
                            <div className='space-y-1 lg:space-y-5 lg:max-w-2xl'>
                                <p className='text-2xl font-semibold'>Rice</p>
                                <p>Rs.250.00</p>
                                <p className="text-gray-500">Red Rice will keep your health in a good way</p>
                            </div>
                        </div>
                    </div>
                </Typography>
            </AccordionSummary>
            <AccordionDetails>
                <form>
                    <div className='flex-wrap'>
                        {
                            demo.map((item) =>
                                <div>
                                    <p>{item.category}</p>
                                    
                                    <FormGroup>
                                    {item.ingrediants.map((item)=><FormControlLabel 
                                    control={<Checkbox defaultChecked />} 
                                    label={item} />)}
                                    
                                </FormGroup>
                                </div>
                                )
                    
                }
                    </div>
                </form>
            </AccordionDetails>
        </Accordion>
    )
}

export default MenuCard