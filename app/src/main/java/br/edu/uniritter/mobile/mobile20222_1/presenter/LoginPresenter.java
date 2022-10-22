package br.edu.uniritter.mobile.mobile20222_1.presenter;

import android.content.Intent;
import android.content.res.Resources;

import br.edu.uniritter.mobile.mobile20222_1.R;
import br.edu.uniritter.mobile.mobile20222_1.model.User;
import br.edu.uniritter.mobile.mobile20222_1.repository.UserRepository;
import br.edu.uniritter.mobile.mobile20222_1.systemService.UserServices;
import br.edu.uniritter.mobile.mobile20222_1.view.MainActivity;

public class LoginPresenter implements LoginPresenterContract.presenter{
    private LoginPresenterContract.view activity;

    public LoginPresenter(LoginPresenterContract.view activity) {
        this.activity = activity;
    }

    @Override
    public void checkLogin(String login, String password) {
        //UserRepository repo  = UserRepository.getInstance(activity.getActivity(), null);
        //User u = repo.getUserByUserLogin(login);
        UserServices userServices = new UserServices(UserServices.REST_REPO, activity.getActivity());
        User u = userServices.getUserByUserLogin(login);

        if (u == null || ! u.getPassword().equals(password)) {
            activity.message("Usuário ou senha Inválido");
        } else {
            //u.setPassword("trocada");
            validLogin(u);
        }
    }

    private void validLogin(User user) {
        Intent intent = new Intent(activity.getActivity(), MainActivity.class);
        //intent.putExtra("userId", user.getId());
        intent.putExtra("userObj", user);
        activity.preferencesUserUpdate(user.getId());
        activity.getActivity().startActivity(intent);
    }
}
