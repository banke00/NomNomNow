package app;

import data_access.Accounts;
import data_access.SearchNameDataAccessObject;
import entity.BusinessAccountFactoryInterface;
import entity.SearchNameResult;
import interface_adapter.add_business.AddBusinessAccountController;
import interface_adapter.add_business.AddBusinessAccountViewModel;
import interface_adapter.add_user.AddUserController;
import interface_adapter.add_user.AddUserPresenter;
import interface_adapter.add_user.AddUserViewModel;
import interface_adapter.seached_name.SearchedNameViewModel;
import interface_adapter.search_name.SearchNameController;
import interface_adapter.search_name.SearchNameViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_business.AddBusinessAccountPresenter;
import interface_adapter.signup.SignUpPresenter;
import interface_adapter.signup.SignUpViewModel;
import use_case.add_business.AddBusinessAccountDataAccessInterface;
import use_case.add_business.AddBusinessAccountInteractor;
import use_case.add_business.AddBusinessAccountOutputBoundary;
import use_case.add_user.AddUserInteractor;
import use_case.search_name.SearchNameInputData;
import use_case.signup.SignUpInteractor;
import view.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("NomNomNow!!!");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        SearchNameViewModel searchNameViewModel = new SearchNameViewModel();
        SearchedNameViewModel searchedNameViewModel = new SearchedNameViewModel();
        SignUpViewModel signupViewModel = new SignUpViewModel();
        AddBusinessAccountViewModel addBusinessAccountViewModel = new AddBusinessAccountViewModel();
        AddUserViewModel addUserViewModel = new AddUserViewModel();
        AddBusinessAccountViewModel addBusinessAccountViewModel1 = new AddBusinessAccountViewModel();

        //Making Data Access Objects
        SearchNameDataAccessObject searchNameDataAccessObject = new SearchNameDataAccessObject();
        Accounts dataAccessObject = new Accounts();

        // Creating AddUser View
        AddUserView addUserView = AddUserUseCaseFactory.createUserView(
                viewManagerModel,
                searchNameViewModel,
                addUserViewModel,
                dataAccessObject);
        views.add(addUserView, addUserView.viewName);

        // Creating AddBusiness View
        AddBusinessAccountView addBusinessAccountView = AddBusinessUseCaseFactory.createBusinessView(
                viewManagerModel,
                searchNameViewModel,
                addBusinessAccountViewModel,
                dataAccessObject);
        views.add(addBusinessAccountView, addBusinessAccountView.viewName);

        // Creating SearchName View
        SearchNameView searchNameView = SearchNameUseCaseFactory.createSearchNameView(
                viewManagerModel,
                searchNameViewModel,
                searchNameDataAccessObject,
                searchedNameViewModel);
        views.add(searchNameView, searchNameView.viewName);

        // Creating SearchedName View
        SearchedNameView searchedNameView = new SearchedNameView(searchedNameViewModel, viewManagerModel);
        views.add(searchedNameView, searchedNameView.viewName);

        // THE DEFAULT VIEW
        SignUpView signUpView = SignUpUseCaseFactory.createSignUpView(
                viewManagerModel,
                signupViewModel,
                addUserViewModel,
                addBusinessAccountViewModel,
                dataAccessObject);
        views.add(signUpView, signUpView.viewName);
        viewManagerModel.setActiveView(signUpView.viewName);
        viewManagerModel.firePropertyChanged();


        application.pack();
        application.setVisible(true);

        /// Testing SearchFeature
        SearchNameInputData searchNameInputData = new SearchNameInputData("ice-cream", "Toronto");
        SearchNameResult result = searchNameDataAccessObject.getSearchName(searchNameInputData);
        System.out.println(result.toString());
    }
}
