import React, {useEffect, useState } from 'react';
import img3 from '../../assets/images/buttons/add/add-push.png'
import img2 from '../../assets/images/buttons/add/add-point.png'
import img1 from '../../assets/images/buttons/add/add-nonclick.png'
import lock from '../../assets/images/buttons/lock-nonclick.png'


const AddClientButton = ({toggle , accessLock}) => {
    const [image, setImage] = useState(lock);

    const hasAccess = () => {
        return !accessLock;
    };

    const handleLeave = () => {
        if (hasAccess()) {
            setImage(img1);
        } else {
            setImage(lock)
        }
    };

    const handleHover = () => {
        if (hasAccess()) {
            setImage(img2);
        } else {
            setImage(lock)
        }
    };

    const handlePress = () => {
        if (hasAccess()) {
            setImage(img3);
            toggle();
        } else {
            setImage(lock)
        }
    };
    useEffect(() => {
        if (accessLock) {
            setImage(lock);
        } else {
            setImage(img1);
        }
    }, [accessLock]);

    return (
        <div className="col-lg-12 d-flex mb-2 mt-4 justify-content-center user-select-none">
            <img
                className=""
                src={image}
                alt="button"
                draggable="false"
                style={{width: "15%", height: "10%", marginTop: "3vh"}}
                onMouseEnter={handleHover}
                onMouseLeave={handleLeave}
                onMouseDown={handlePress}
                onMouseUp={handleHover}
            >
            </img>
        </div>
    );
}

export default AddClientButton;
