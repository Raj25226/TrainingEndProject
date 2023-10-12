import React, { useState, useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../../node_modules/bootstrap-icons/font/bootstrap-icons.css';
import AddIndent from './AddIndent';
import ViewIndents from './ViewIndent';
import EditIndent from './EditIndent';
import { Link } from "react-router-dom";
const IndentList = () => {
  const [items, setItems] = useState([]);
  // const [showAddModal, setShowAddModal] = useState(false);
  const [showviewModal, setviewAddModal] = useState(false); 
  const [showeditModal, seteditAddModal] = useState(false); 
  const [selectedHeaderId, setSelectedHeaderId] = useState(0); 
  const [newItem, setNewItem] = useState({
    field1: '',
    field2: '',
    field3: '',
    field4: '',
  });

  const fetchApiData = async () => {
    try {
      const response = await fetch('http://localhost:8080/mj/indentheader');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setItems(data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  useEffect(() => {
    fetchApiData();
  }, []);
  // const handleDeleteindent = async (id) => {
  //   console.log(id);
  //   fetch(`http://localhost:8080/mj/indent1/${id}`, {
  //     method: 'DELETE',
  //   })
  //     .then((response) => {
  //       if (response.ok) {
  //         const updatedItems = items.filter((item) => item.indentId !== id);
  //         setItems(updatedItems);
  //       } else {
  //         console.error('Error deleting item:', response);
  //       }
  //     })
  //     .catch((error) => {
  //       console.error('Error deleting item:', error);
  //     });
  // };
  const handleDeleteItem = async (id) => {
    // await handleDeleteindent(id);
    try {
      const response = await fetch(`http://localhost:8080/mj/indentheader/${id}`, {
        method: 'DELETE',
      });
      if (response.ok) {
        const updatedItems = items.filter((item) => item.indentHeaderId !== id);
        setItems(updatedItems);
      } else {
        console.error('Error deleting item:', response);
      }
    } catch (error) {
      console.error('Error deleting item:', error);
    }

  };  
  const handleViewItemClick = (headerId) => {
    console.log(headerId);
    setSelectedHeaderId(headerId); // Set the selected headerId
    setviewAddModal(true);
  };

  return (
    <div className="container mt-4">
      <div className="card" style={{ marginTop: '15%' }}>
        <div className="card-header d-flex justify-content-between align-items-center">
          <h1>Indent List</h1>
          <Link style={{width:"150px", color:"white"}} className="btn" to="/addindent2">
            Add
          </Link>
        </div>
        <div className="card-body">
          {items.length === 0 ? (
            <h6>No Data Found</h6>
          ) : (
            <table className="table">
              <thead>
                <tr>
                  <th>Indentheader</th>
                  <th>Description</th>
                  <th>Netprice</th>
                </tr>
              </thead>
              <tbody>
                {items.map((item, index) => (
                  <tr key={index}>
                    <td>{item.indentHeaderId}</td>
                    <td>{item.description}</td>
                    <td>{item.netprice}</td>
                    <td>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => handleDeleteItem(item.indentHeaderId)}
                      >
                        <i className="bi bi-trash"></i>
                      </button>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => handleViewItemClick(item.indentHeaderId)}
                      >
                        <i className="bi bi-eye"></i>
                      </button>
                      <button
                        style={{ marginLeft: '5px' }}
                        onClick={() => seteditAddModal(true)}
                      >
                        <i className="bi bi-pen"></i>
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </div>
      
     
      {showviewModal && (
        <div className="modal" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Add Item</h5>
                <button
                  type="button"
                  className="close"
                  data-dismiss="modal"
                  aria-label="Close"
                  onClick={() => setviewAddModal(false)}
                >
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <div className="form-group">
                 
                <ViewIndents headerId={selectedHeaderId} />
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
      {showeditModal && (
        <div className="modal" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
          <div className="modal-dialog" role="document">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Add Item</h5>
                <button
                  type="button"
                  className="close"
                  data-dismiss="modal"
                  aria-label="Close"
                  onClick={() => seteditAddModal(false)}
                >
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body">
                <div className="form-group">
                 
                  <EditIndent></EditIndent>
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
      
    </div>
  );
};



export default IndentList;
