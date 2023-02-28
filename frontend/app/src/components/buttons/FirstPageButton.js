import React, { useState } from 'react';
import img3 from '../../assets/images/buttons/button right two/button-right-two-push.png'
import img2 from '../../assets/images/buttons/button right two/button-right-two-point.png'
import img1 from '../../assets/images/buttons/button right two/button-right-two-nonclick.png'
const FirstPageButton = props => {
    const [image, setImage] = useState(img1);

    const handleLeave = () => {
        setImage(img1);
    };

    const handleHover = () => {
        setImage(img2);
    };

    const handlePress = () => {
        setImage(img3);
        props.setPageNumber(0);
        props.updateTable();
    };

    return (
        <div className="">
            <img
                className=""
                src={image}
                alt="button"
                style={{width: "200px", height: "100px" ,marginTop: '-40px'}}
                onMouseEnter={handleHover}
                onMouseLeave={handleLeave}
                onMouseDown={handlePress}
                onMouseUp={handleHover}
            >
            </img>
        </div>
    );
}

export default FirstPageButton;