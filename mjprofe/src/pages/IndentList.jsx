import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import '../../node_modules/bootstrap-icons/font/bootstrap-icons.css'
import AddIndent from './AddIndent';

const IndentList = () => {
  const [items, setItems] = useState([]);
  const [showAddModal, setShowAddModal] = useState(false);
  const [newItem, setNewItem] = useState({
    field1: '',
    field2: '',
    field3: '',
    field4: '',
  });

  const jsonArray = [
    {
      field1: 'Value 1A',
      field2: 'Value 1B',
      field3: 'Value 1C',
      field4: 'Value 1D',
    },
    {
      field1: 'Value 2A',
      field2: 'Value 2B',
      field3: 'Value 2C',
      field4: 'Value 2D',
    },
    {
      field1: 'Value 3A',
      field2: 'Value 3B',
      field3: 'Value 3C',
      field4: 'Value 3D',
    },
  ];

  const handleDeleteItem = (index) => {
    const updatedItems = items.filter((item, i) => i !== index);
    setItems(updatedItems);
  };

  const handleAddItem = () => {
    setItems([...items, newItem]);
    setNewItem({
      field1: '',
      field2: '',
      field3: '',
      field4: '',
    });
    setShowAddModal(false);
  };

  return (
    <div className="container mt-4">
      <div className="card">
        <div className="card-header d-flex justify-content-between align-items-center">
          <h1>Indent List</h1>
          <button
            className="btn btn-success"
            onClick={() => setShowAddModal(true)}
          >
            Add
          </button>
        </div>
        <div className="card-body">
         
          <table className="table">
            <thead>
              <tr>
                <th>Field 1</th>
                <th>Field 2</th>
                <th>Field 3</th>
                <th>Field 4</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {jsonArray.map((item, index) => (
                <tr key={index}>
                  <td>{item.field1}</td>
                  <td>{item.field2}</td>
                  <td>{item.field3}</td>
                  <td>{item.field4}</td>
                  <td>
                  <button
                    style={{marginLeft:'5px'}}
                      onClick={() => handleDeleteItem(index)}
                    >
                      <i class="bi bi-eye"></i>
                    </button>
                    <button
                    style={{marginLeft:'5px'}}
                      onClick={() => handleEditItem(index)}
                    >
                      <i className="bi bi-pencil-square"></i>
                    </button>
                    <button
                    style={{marginLeft:'5px'}}
                      onClick={() => handleDeleteItem(index)}
                    >
                      <i className="bi bi-trash"></i>
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      {showAddModal && (
        <div className="modal" tabIndex="-1" role="dialog" style={{ display: 'block' }}>
          <div className="modal-dialog" role="document" >
            <div className="modal-content" >
              <div className="modal-header" >
                <h5 className="modal-title">Add Item</h5>
                <button
                  type="button"
                  className="close"
                  data-dismiss="modal"
                  aria-label="Close"
                  onClick={() => setShowAddModal(false)}
                >
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div className="modal-body  " >
                <div className="form-group" >
                 
                 <AddIndent ></AddIndent>
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
